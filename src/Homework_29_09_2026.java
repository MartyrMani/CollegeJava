import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class Homework_29_09_2026 {
    static HttpClient client = HttpClient.newHttpClient();


    public static void main(String[] args) throws Exception {

        System.out.println("ЗАДАНИЯ СО СЛАЙДА 31");

        task31_3();

        task31_4();

        task31_5();


        System.out.println("\nЗАДАНИЯ СО СЛАЙДА 33");

        ApiClient api = new ApiClient();

        System.out.println("\nGET через ApiClient");

        String getResult = api.get(
                "https://jsonplaceholder.typicode.com/posts/1"
        );

        System.out.println(getResult);


        System.out.println("\nPOST через ApiClient");

        String postJson = """
                {
                  "title": "Новый пост",
                  "body": "Текст поста",
                  "userId": 1
                }
                """;

        String postResult = api.post(
                "https://jsonplaceholder.typicode.com/posts",
                postJson
        );

        System.out.println(postResult);


        System.out.println("\nPUT через ApiClient");

        String putJson = """
                {
                  "id": 1,
                  "title": "Изменённый пост",
                  "body": "Новый текст",
                  "userId": 1
                }
                """;

        String putResult = api.put(
                "https://jsonplaceholder.typicode.com/posts/1",
                putJson
        );

        System.out.println(putResult);


        System.out.println("\nDELETE через ApiClient");

        String deleteResult = api.delete(
                "https://jsonplaceholder.typicode.com/posts/1"
        );

        System.out.println(deleteResult);


        asyncRequests();


        retryRequest(
                "https://jsonplaceholder.typicode.com/posts/1"
        );
    }


    // ЗАДАНИЯ СО СЛАЙДА 31


    // Задача 3
    public static void task31_3() throws Exception {

        System.out.println("\nЗадача 31.3");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(
                        URI.create(
                                "https://jsonplaceholder.typicode.com/users/1"
                        )
                )
                .GET()
                .build();

        HttpResponse<String> response =
                client.send(
                        request,
                        HttpResponse.BodyHandlers.ofString()
                );

        System.out.println(
                "Статус: " + response.statusCode()
        );

        System.out.println(
                "Тело ответа:"
        );

        System.out.println(
                response.body()
        );
    }


    // Задача 4
    public static void task31_4() throws Exception {

        System.out.println("\nЗадача 31.4");

        String json = """
                {
                  "title": "Новый пост",
                  "body": "Текст нового поста",
                  "userId": 1
                }
                """;

        HttpRequest request =
                HttpRequest.newBuilder()
                        .uri(
                                URI.create(
                                        "https://jsonplaceholder.typicode.com/posts"
                                )
                        )
                        .header(
                                "Content-Type",
                                "application/json"
                        )
                        .POST(
                                HttpRequest.BodyPublishers
                                        .ofString(json)
                        )
                        .build();

        HttpResponse<String> response =
                client.send(
                        request,
                        HttpResponse.BodyHandlers.ofString()
                );

        System.out.println(
                "Статус: " + response.statusCode()
        );

        System.out.println(
                "Ответ: " + response.body()
        );

        if (response.statusCode() == 201) {

            System.out.println(
                    "Пост успешно создан"
            );
        }
    }


    // Задача 5
    public static void task31_5() throws Exception {

        System.out.println("\nЗадача 31.5");

        HttpRequest request =
                HttpRequest.newBuilder()
                        .uri(
                                URI.create(
                                        "https://jsonplaceholder.typicode.com/users/999999"
                                )
                        )
                        .GET()
                        .build();

        HttpResponse<String> response =
                client.send(
                        request,
                        HttpResponse.BodyHandlers.ofString()
                );

        int status = response.statusCode();

        if (status == 200) {

            System.out.println(
                    "Ресурс найден"
            );

        } else if (status == 404) {

            System.out.println(
                    "Ошибка 404: ресурс не найден"
            );

        } else {

            System.out.println(
                    "Другой статус: " + status
            );
        }

        System.out.println(
                "Тело ответа: " + response.body()
        );
    }


    // ЗАДАНИЯ СО СЛАЙДА 33


    // Задание 2
    static class ApiClient {

        private final HttpClient client =
                HttpClient.newHttpClient();


        public String get(String url) throws Exception {

            HttpRequest request =
                    HttpRequest.newBuilder()
                            .uri(
                                    URI.create(url)
                            )
                            .GET()
                            .build();

            HttpResponse<String> response =
                    client.send(
                            request,
                            HttpResponse.BodyHandlers.ofString()
                    );

            System.out.println(
                    "GET статус: "
                            + response.statusCode()
            );

            return response.body();
        }


        public String post(
                String url,
                String json
        ) throws Exception {

            HttpRequest request =
                    HttpRequest.newBuilder()
                            .uri(
                                    URI.create(url)
                            )
                            .header(
                                    "Content-Type",
                                    "application/json"
                            )
                            .POST(
                                    HttpRequest.BodyPublishers
                                            .ofString(json)
                            )
                            .build();

            HttpResponse<String> response =
                    client.send(
                            request,
                            HttpResponse.BodyHandlers.ofString()
                    );

            System.out.println(
                    "POST статус: "
                            + response.statusCode()
            );

            return response.body();
        }


        public String put(
                String url,
                String json
        ) throws Exception {

            HttpRequest request =
                    HttpRequest.newBuilder()
                            .uri(
                                    URI.create(url)
                            )
                            .header(
                                    "Content-Type",
                                    "application/json"
                            )
                            .PUT(
                                    HttpRequest.BodyPublishers
                                            .ofString(json)
                            )
                            .build();

            HttpResponse<String> response =
                    client.send(
                            request,
                            HttpResponse.BodyHandlers.ofString()
                    );

            System.out.println(
                    "PUT статус: "
                            + response.statusCode()
            );

            return response.body();
        }


        public String delete(String url)
                throws Exception {

            HttpRequest request =
                    HttpRequest.newBuilder()
                            .uri(
                                    URI.create(url)
                            )
                            .DELETE()
                            .build();

            HttpResponse<String> response =
                    client.send(
                            request,
                            HttpResponse.BodyHandlers.ofString()
                    );

            System.out.println(
                    "DELETE статус: "
                            + response.statusCode()
            );

            return response.body();
        }
    }


    // Задание 3
    public static void asyncRequests() {

        System.out.println(
                "\nАсинхронные запросы"
        );

        HttpRequest request1 =
                HttpRequest.newBuilder()
                        .uri(
                                URI.create(
                                        "https://jsonplaceholder.typicode.com/users/1"
                                )
                        )
                        .GET()
                        .build();

        HttpRequest request2 =
                HttpRequest.newBuilder()
                        .uri(
                                URI.create(
                                        "https://jsonplaceholder.typicode.com/users/2"
                                )
                        )
                        .GET()
                        .build();

        HttpRequest request3 =
                HttpRequest.newBuilder()
                        .uri(
                                URI.create(
                                        "https://jsonplaceholder.typicode.com/users/3"
                                )
                        )
                        .GET()
                        .build();


        CompletableFuture<HttpResponse<String>> future1 =
                client.sendAsync(
                        request1,
                        HttpResponse.BodyHandlers.ofString()
                );

        CompletableFuture<HttpResponse<String>> future2 =
                client.sendAsync(
                        request2,
                        HttpResponse.BodyHandlers.ofString()
                );

        CompletableFuture<HttpResponse<String>> future3 =
                client.sendAsync(
                        request3,
                        HttpResponse.BodyHandlers.ofString()
                );


        CompletableFuture<Void> all =
                CompletableFuture.allOf(
                        future1,
                        future2,
                        future3
                );

        all.join();


        System.out.println(
                "Ответ пользователя 1:"
        );

        System.out.println(
                future1.join().body()
        );


        System.out.println(
                "\nОтвет пользователя 2:"
        );

        System.out.println(
                future2.join().body()
        );


        System.out.println(
                "\nОтвет пользователя 3:"
        );

        System.out.println(
                future3.join().body()
        );
    }


    // Задание 4
    public static void retryRequest(
            String url
    ) throws Exception {

        System.out.println(
                "\nПовтор запроса при 5xx"
        );

        int maxAttempts = 3;

        for (
                int attempt = 1;
                attempt <= maxAttempts;
                attempt++
        ) {

            System.out.println(
                    "Попытка №" + attempt
            );

            HttpRequest request =
                    HttpRequest.newBuilder()
                            .uri(
                                    URI.create(url)
                            )
                            .GET()
                            .build();

            HttpResponse<String> response =
                    client.send(
                            request,
                            HttpResponse.BodyHandlers.ofString()
                    );

            int status =
                    response.statusCode();

            System.out.println(
                    "Статус: " + status
            );


            if (
                    status >= 500
                            && status <= 599
            ) {

                System.out.println(
                        "Ошибка сервера"
                );

                if (attempt < maxAttempts) {

                    System.out.println(
                            "Повтор через 1 секунду..."
                    );

                    Thread.sleep(1000);
                }

            } else {

                System.out.println(
                        "Запрос завершён"
                );

                System.out.println(
                        response.body()
                );

                break;
            }
        }
    }
}
