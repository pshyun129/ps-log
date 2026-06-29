package apiTest;

import java.io.BufferedWriter;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class KakaoAddressGeocoder {

    // 카카오 Developers에서 발급받은 REST API 키를 넣으면 됨
    // 예: private static final String KAKAO_REST_API_KEY = "abc123...";
    private static final String KAKAO_REST_API_KEY = "";

    public static void main(String[] args) throws Exception {

        String[] addresses = {
                "전라남도 여수시 삼산면 하늘담길 14-1",
                "전라남도 여수시 삼산면 거문길 92",
                "전라남도 여수시 봉산남8길 17-10",
                "전라남도 여수시 대교로 38",
                "전라남도 여수시 시청동2길 13",
                "전라남도 여수시 삼산면 거문도등대길 54",
                "전라남도 여수시 문수로 106",
                "전라남도 여수시 여문문화길 76-1",
                "전라남도 여수시 삼산면 덕촌리",
                "전라남도 여수시 무선6길 43-4",
                "전라남도 여수시 오동도로 61-14",
                "전라남도 여수시 돌산읍 향일암로 134",
                "전라남도 여수시 둔덕2길 6-2",
                "전라남도 여수시 삼산면 삼호교길 16",
                "전라남도 여수시 봉산남5길 20 (봉산동)",
                "전라남도 여수시 학동1길 16-6",
                "전라남도 여수시 공화북2길 25-1 (공화동)",
                "전라남도 여수시 율촌면 청대길 7",
                "전라남도 여수시 돌산읍 강남5길 33",
                "전라남도 여수시 여문1로 43-17",
                "전라남도 여수시 봉산남7길 5-2 (봉산동)",
                "전라남도 여수시 돌산읍 향일암로 134",
                "전라남도 여수시 봉산남8길 17-22 (봉산동)",
                "전라남도 여수시 이순신광장로 203",
                "전라남도 여수시 여서1로 65",
                "전라남도 여수시 봉산남7길 8 (봉산동)",
                "전라남도 여수시 충무4길 5 (충무동)",
                "전라남도 여수시 거북선공원1길 8",
                "전라남도 여수시 무선6길 42-4 (선원동)",
                "전라남도 여수시 공화남2길 8-1 (공화동)",
                "전라남도 여수시 율촌면 여순로 707",
                "전라남도 여수시 성산3길 24-7 (화장동)",
                "전라남도 여수시 오동도로 90 (수정동)",
                "전라남도 여수시 소호로 295",
                "전라남도 여수시 박람회길 61",
                "전라남도 여수시 시청서6길 19",
                "전라남도 여수시 소라면 안심산길 155",
                "전라남도 여수시 신월로 496-25",
                "전라남도 여수시 망양로 20",
                "전라남도 여수시 화양면 화양로 1347-1",
                "전라남도 여수시 돌산읍 향일암로 69",
                "전라남도 여수시 봉산2로 19",
                "전라남도 여수시 공화북2길 13",
                "전라남도 여수시 봉산남7길 11-11(봉산동)",
                "전라남도 여수시 교동남1길 6-3",
                "전라남도 여수시 오림4길 55",
                "전라남도 여수시 시청동2길 16",
                "전라남도 여수시 선소로 15-4",
                "전라남도 여수시 여문문화2길 10",
                "전라남도 여수시 봉산남7길 5-8",
                "전라남도 여수시 오림2길 12-6",
                "전라남도 여수시 교동남1길 5-5",
                "전라남도 여수시 돌산읍 강남6길 46",
                "전라남도 여수시 돌산읍 평사리",
                "전라남도 여수시 광무1길 25-4",
                "전라남도 여수시 봉산남8길 11",
                "전라남도 여수시 봉산남7길 11-15",
                "전라남도 여수시 봉산남6길 11-9",
                "전라남도 여수시 율촌면 월산리",
                "전라남도 여수시 학동2길 23",
                "전라남도 여수시 봉산남7길 17-9 (봉산동)",
                "전라남도 여수시 학동2길 15",
                "전라남도 여수시 여문문화길 69",
                "전라남도 여수시 돌산읍 강남6길 48",
                "전라남도 여수시 시청서5길 26",
                "전라남도 여수시 충무2길 8",
                "전라남도 여수시 율촌면 조화길 3",
                "전라남도 여수시 교동남1길 6-12",
                "전라남도 여수시 시청동3길 12-15",
                "전라남도 여수시 오림4길 53",
                "전라남도 여수시 오동도로 74",
                "전라남도 여수시 시청서6길 5",
                "전라남도 여수시 시청서6길 3",
                "전라남도 여수시 시청서6길 11",
                "전라남도 여수시 충무3길 3",
                "전라남도 여수시 여문1로 43-7",
                "전라남도 여수시 시청서6길 15",
                "전라남도 여수시 시청동3길 30-6",
                "전라남도 여수시 남면 안도해변길 25",
                "전라남도 여수시 돌산읍 율림리",
                "전라남도 여수시 돌산읍 향일암로 134",
                "전라남도 여수시 시청서1길 56",
                "전라남도 여수시 봉산남8길 7-20",
                "전라남도 여수시 둔덕3길 12",
                "전라남도 여수시 무선6길 42-4",
                "전라남도 여수시 시청동2길 22-1",
                "전라남도 여수시 둔덕3길 6-1",
                "전라남도 여수시 성산3길 21-3",
                "전라남도 여수시 봉산남6길 17-7",
                "전라남도 여수시 둔덕2길 6-6",
                "전라남도 여수시 오동도로 75",
                "전라남도 여수시 시청서6길 13",
                "전라남도 여수시 거북선공원2길 19",
                "전라남도 여수시 시청동3길 30-5",
                "전라남도 여수시 돌산읍 강남로 52",
                "전라남도 여수시 둔덕3길 14",
                "전라남도 여수시 여문1로 39-14",
                "전라남도 여수시 여문1로 43-21",
                "전라남도 여수시 여문1로 43-13",
                "전라남도 여수시 공화남2길 20",
                "전라남도 여수시 흥국로 32-8",
                "전라남도 여수시 시청서1길 60",
                "전라남도 여수시 여문문화2길 69",
                "전라남도 여수시 돌산읍 강남1길 39-17",
                "전라남도 여수시 봉산남7길 13(봉산동)",
                "전라남도 여수시 시청서6길 25",
                "전라남도 여수시 시청서6길 23",
                "전라남도 여수시 봉산남5길 8",
                "전라남도 여수시 시청서5길 16",
                "전라남도 여수시 오동도로 61-6",
                "전라남도 여수시 관문서2길 7",
                "전라남도 여수시 돌산읍 강남로 45",
                "전라남도 여수시 여서1로 95-9",
                "전라남도 여수시 오림4길 59",
                "전라남도 여수시 돌산읍 평사로 745-7",
                "전라남도 여수시 성산3길 21-4",
                "전라남도 여수시 돌산읍 강남해안로 93",
                "전라남도 여수시 봉산남6길 12",
                "전라남도 여수시 오림4길 53",
                "전라남도 여수시 화양면 화양로 1347-1",
                "전라남도 여수시 여문문화2길 65",
                "전라남도 여수시 학동서1길 13",
                "전라남도 여수시 오림2길 12",
                "전라남도 여수시 여문1로 43-7",
                "전라남도 여수시 연등8길 17-1",
                "전라남도 여수시 시청동2길 16",
                "전라남도 여수시 선소로 15-4",
                "전라남도 여수시 오림4길 61",
                "전라남도 여수시 시청로 6길 15",
                "전라남도 여수시 둔덕2길 6-2",
                "전라남도 여수시 시청동2길 33",
                "전라남도 여수시 돌산읍 강남1길 39-17",
                "전라남도 여수시 좌수영로 641",
                "전라남도 여수시 돌산읍 강남로 45",
                "전라남도 여수시 봉산동 258-4",
                "전라남도 여수시 성산3길 24-8 (화장동)",
                "전라남도 여수시 성산3길 21-10 (화장동)",
                "전라남도 여수시 여문문화2길 33 (문수동)",
                "전라남도 여수시 돌산읍 강남6길 48",
                "전라남도 여수시 봉산동 257-1",
                "전라남도 여수시 오림4길 61 (오림동)",
                "전라남도 여수시 오동도로 61-20 (수정동)",
                "전라남도 여수시 공화동 1087-2",
                "전라남도 여수시 봉산2로 33 (봉산동)",
                "전라남도 여수시 돌산읍 향일암로 75",
                "전라남도 여수시 봉산남2길 23-22 (봉산동)",
                "전라남도 여수시 봉산남6길 7 (봉산동)",
                "전라남도 여수시 봉산남8길 7-20 (봉산동)",
                "전라남도 여수시 학동서1길 5 (학동)",
                "전라남도 여수시 시청동3길 30-7 (학동)",
                "전라남도 여수시 돌산읍 강남6길 46"
        };

        String[][] results = new String[addresses.length][3];

        for (int i = 0; i < addresses.length; i++) {
            String address = addresses[i];

            System.out.println((i + 1) + "번 검색 중: " + address);

            GeoResult geoResult = geocode(address);

            results[i][0] = address;

            if (geoResult == null) {
                results[i][1] = "";
                results[i][2] = "";
                System.out.println("  -> 결과 없음");
            } else {
                results[i][1] = geoResult.latitude;
                results[i][2] = geoResult.longitude;
                System.out.println("  -> 위도: " + geoResult.latitude + ", 경도: " + geoResult.longitude);
            }

            // 너무 빠른 연속 호출 방지
            Thread.sleep(150);
        }

        saveToDesktop(results);

        System.out.println("완료! 바탕화면에 kakao_geocode_result.tsv 파일이 생성되었습니다.");
    }

    private static GeoResult geocode(String address) {
        try {
            String url = buildGeocodeUrl(address);
            String response = sendGet(url);

            String x = extractFirstValue(response, "\"x\":\"");
            String y = extractFirstValue(response, "\"y\":\"");

            if (x == null || y == null) {
                return null;
            }

            // Kakao 응답: x = 경도, y = 위도
            return new GeoResult(y, x);

        } catch (Exception e) {
            System.out.println("  -> 오류 발생: " + e.getMessage());
            return null;
        }
    }

    private static String buildGeocodeUrl(String address) {
        String encodedAddress = URLEncoder.encode(address, StandardCharsets.UTF_8);

        return "https://dapi.kakao.com/v2/local/search/address.json"
                + "?query=" + encodedAddress;
    }

    private static String sendGet(String urlString) throws Exception {
        URL url = new URL(urlString);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Authorization", "KakaoAK " + KAKAO_REST_API_KEY);
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(10000);

        int responseCode = connection.getResponseCode();

        InputStream inputStream;

        if (responseCode >= 200 && responseCode < 300) {
            inputStream = connection.getInputStream();
        } else {
            inputStream = connection.getErrorStream();
        }

        byte[] bytes = inputStream.readAllBytes();
        String response = new String(bytes, StandardCharsets.UTF_8);

        if (responseCode < 200 || responseCode >= 300) {
            System.out.println("  -> HTTP 오류 " + responseCode + ": " + response);
        }

        return response;
    }

    private static String extractFirstValue(String json, String keyPattern) {
        int start = json.indexOf(keyPattern);

        if (start == -1) {
            return null;
        }

        start += keyPattern.length();

        int end = json.indexOf("\"", start);

        if (end == -1) {
            return null;
        }

        return json.substring(start, end);
    }

    private static void saveToDesktop(String[][] results) throws Exception {
        String userHome = System.getProperty("user.home");
        Path desktopPath = Path.of(userHome, "Desktop", "kakao_geocode_result.tsv");

        try (BufferedWriter writer = Files.newBufferedWriter(desktopPath, StandardCharsets.UTF_8)) {
            writer.write("번호\t주소\t위도\t경도");
            writer.newLine();

            for (int i = 0; i < results.length; i++) {
                writer.write((i + 1) + "\t" + results[i][0] + "\t" + results[i][1] + "\t" + results[i][2]);
                writer.newLine();
            }
        }
    }

    private static class GeoResult {
        String latitude;
        String longitude;

        GeoResult(String latitude, String longitude) {
            this.latitude = latitude;
            this.longitude = longitude;
        }
    }
}