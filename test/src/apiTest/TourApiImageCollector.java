package apiTest;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class TourApiImageCollector {

    // 공공데이터포털에서 받은 Encoding 인증키를 넣는 걸 추천
    private static final String SERVICE_KEY = "";

    private static final String MOBILE_OS = "ETC";
    private static final String MOBILE_APP = "NightTrip";

    public static void main(String[] args) throws Exception {

        /*
         * places[i][0] = 실제 장소명
         * places[i][1] = TourAPI 검색용 키워드
         */
        String[][] places = {
                {"낭만 포차 거리", "여수 낭만포차"},
                {"종포해양공원", "여수 종포해양공원"},
                {"여수해상케이블카", "여수해상케이블카"},
                {"돌산공원", "여수 돌산공원"},
                {"오동도와 음악분수", "오동도"},
                {"소호동동다리", "여수 소호동동다리"},
                {"여수국가산업단지 전망대", "여수국가산업단지"},
                {"여수세계박람회장", "여수세계박람회장"},
                {"빅오쇼", "여수 빅오쇼"},
                {"여수밤바다 낭만버스킹", "여수 낭만버스킹"},
                {"시간을 달리는 버스커", "여수 야간시티투어"},
                {"밤디불거리", "여수 밤디불"},
                {"여수 국가유산 야행", "여수 문화유산야행"},
                {"함께 어울려 행복한 마칭퍼레이드", "여수 마칭퍼레이드"},
                {"캔들라이트 콘서트", "여수 캔들라이트 콘서트"},
                {"미남크루즈 힐링 야경 투어", "미남크루즈"},
                {"미남크루즈 선상 불꽃투어", "미남크루즈"},
                {"이사부크루즈 낭만밤바다투어", "이사부크루즈"},
                {"이사부크루즈 야경불꽃투어", "이사부크루즈"},
                {"여수거북선호 힐링야경투어", "여수거북선호"},
                {"여수거북선호 선상불꽃투어", "여수거북선호"},
                {"오동도 유람선 야간투어", "오동도 유람선"},
                {"여수 오션크루즈 야경투어", "여수 오션크루즈"},
                {"여수 오션크루즈 선상 불꽃투어", "여수 오션크루즈"},
                {"하멜등대", "여수 하멜등대"},
                {"돌산대교", "여수 돌산대교"},
                {"거북선대교", "여수 거북선대교"},
                {"이순신광장", "여수 이순신광장"},
                {"고소동 천사벽화마을", "여수 고소동 천사벽화마을"},
                {"진남관", "여수 진남관"},
                {"오포대", "여수 오포대"},
                {"여수 선소유적", "여수 선소유적"},
                {"선소대교", "여수 선소대교"},
                {"웅천친수공원", "여수 웅천친수공원"},
                {"웅천해수욕장", "여수 웅천해수욕장"},
                {"장도", "여수 장도"},
                {"GS칼텍스 예울마루", "예울마루"},
                {"만성리 검은모래해변", "만성리 검은모래해변"},
                {"여수해양레일바이크", "여수해양레일바이크"},
                {"무술목해변", "여수 무술목해변"},
                {"무술목전적지", "여수 무술목전적지"},
                {"향일암", "여수 향일암"},
                {"자산공원", "여수 자산공원"},
                {"스카이타워 전망대", "여수 스카이타워"},
                {"아르떼뮤지엄 여수", "아르떼뮤지엄 여수"},
                {"아쿠아플라넷 여수", "아쿠아플라넷 여수"},
                {"여수예술랜드", "여수예술랜드"},
                {"유월드 루지 테마파크", "여수 유월드 루지 테마파크"},
                {"국동항 수변공원", "여수 국동항 수변공원"},
                {"전남해양수산과학관", "전남해양수산과학관"},
                {"여수구항 해양공원", "여수 해양공원"}
        };

        String[] imageUrls = new String[places.length];

        for (int i = 0; i < places.length; i++) {
            String displayName = places[i][0];
            String searchKeyword = places[i][1];

            System.out.println("검색 중: " + displayName + " / 검색어: " + searchKeyword);

            String imageUrl = findImageUrlByKeyword(searchKeyword);

            if (imageUrl == null || imageUrl.isBlank()) {
                imageUrl = "이미지 없음";
            }

            imageUrls[i] = imageUrl;

            // API 연속 호출 방지
            Thread.sleep(300);
        }

        saveToDesktop(places, imageUrls);

        System.out.println("완료! 바탕화면에 tourapi_image_urls.txt 파일이 생성되었습니다.");
    }

    private static String findImageUrlByKeyword(String keyword) {
        try {
            String searchUrl = buildSearchKeywordUrl(keyword);
            Document searchDoc = requestXml(searchUrl);

            // 목록 API에서 대표 이미지가 바로 나오는 경우
            String firstImage = getFirstTagValue(searchDoc, "firstimage");

            if (firstImage != null && !firstImage.isBlank()) {
                return firstImage;
            }

            // firstimage가 없으면 contentid로 상세 이미지 조회
            String contentId = getFirstTagValue(searchDoc, "contentid");

            if (contentId == null || contentId.isBlank()) {
                System.out.println("  -> 검색 결과 또는 contentid 없음");
                return null;
            }

            String detailImageUrl = buildDetailImageUrl(contentId);
            Document detailDoc = requestXml(detailImageUrl);

            String originImgUrl = getFirstTagValue(detailDoc, "originimgurl");

            if (originImgUrl != null && !originImgUrl.isBlank()) {
                return originImgUrl;
            }

            String smallImageUrl = getFirstTagValue(detailDoc, "smallimageurl");

            if (smallImageUrl != null && !smallImageUrl.isBlank()) {
                return smallImageUrl;
            }

            System.out.println("  -> 이미지 없음");
            return null;

        } catch (Exception e) {
            System.out.println("  -> 오류 발생: " + e.getMessage());
            return null;
        }
    }

    private static String buildSearchKeywordUrl(String keyword) {
        String encodedKeyword = URLEncoder.encode(keyword, StandardCharsets.UTF_8);
        String encodedMobileApp = URLEncoder.encode(MOBILE_APP, StandardCharsets.UTF_8);

        return "https://apis.data.go.kr/B551011/KorService2/searchKeyword2"
                + "?serviceKey=" + SERVICE_KEY
                + "&MobileOS=" + MOBILE_OS
                + "&MobileApp=" + encodedMobileApp
                + "&numOfRows=10"
                + "&pageNo=1"
                + "&keyword=" + encodedKeyword
                + "&areaCode=38";
    }

    private static String buildDetailImageUrl(String contentId) {
        String encodedMobileApp = URLEncoder.encode(MOBILE_APP, StandardCharsets.UTF_8);

        return "https://apis.data.go.kr/B551011/KorService2/detailImage2"
                + "?serviceKey=" + SERVICE_KEY
                + "&MobileOS=" + MOBILE_OS
                + "&MobileApp=" + encodedMobileApp
                + "&contentId=" + contentId
                + "&imageYN=Y"
                + "&subImageYN=Y"
                + "&numOfRows=10"
                + "&pageNo=1";
    }

    private static Document requestXml(String urlString) throws Exception {
        URL url = new URL(urlString);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(10000);

        int responseCode = connection.getResponseCode();

        InputStream inputStream;

        if (responseCode >= 200 && responseCode < 300) {
            inputStream = connection.getInputStream();
        } else {
            inputStream = connection.getErrorStream();
        }

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        // XXE 방지용 설정
        factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        factory.setFeature("http://xml.org/sax/features/external-general-entities", false);
        factory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
        factory.setXIncludeAware(false);
        factory.setExpandEntityReferences(false);

        DocumentBuilder builder = factory.newDocumentBuilder();

        return builder.parse(inputStream);
    }

    private static String getFirstTagValue(Document document, String tagName) {
        NodeList nodeList = document.getElementsByTagName(tagName);

        if (nodeList == null || nodeList.getLength() == 0) {
            return null;
        }

        if (nodeList.item(0) == null) {
            return null;
        }

        String value = nodeList.item(0).getTextContent();

        if (value == null || value.isBlank()) {
            return null;
        }

        return value.trim();
    }

    private static void saveToDesktop(String[][] places, String[] imageUrls) throws Exception {
        String userHome = System.getProperty("user.home");

        Path desktopPath = Path.of(userHome, "Desktop", "tourapi_image_urls.txt");

        try (BufferedWriter writer = Files.newBufferedWriter(desktopPath, StandardCharsets.UTF_8)) {
            for (int i = 0; i < imageUrls.length; i++) {
                String displayName = places[i][0];
                String imageUrl = imageUrls[i];

                writer.write((i + 1) + ". " + displayName + " : " + imageUrl);
                writer.newLine();
            }
        }
    }
}