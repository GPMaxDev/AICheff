// layer  play with access to this class

package com.gmail.dev.max.aicheff;

import com.theokanning.openai.image.CreateImageRequest;
import com.theokanning.openai.service.OpenAiService;

public class AiRequstSender  {
    String token = "";// HERE MUST BE TOKEN
    OpenAiService service = new OpenAiService(token);

    public String getImageUrl(String imageRequest){

         String[] urlLink = new String[1];

        new Thread(new Runnable() {
            @Override
            public void run() {

                // Здесь выполняется операция с сетью

                try {
                    CreateImageRequest request = CreateImageRequest.builder()
                        .prompt(imageRequest)
                        .build();

                    urlLink[0]  = (service.createImage(request).getData().get(0).getUrl());
                    service.shutdownExecutor();

                } catch (Exception e) {
                    e.printStackTrace();
                }

                // Обрабатываем результат операции с сетью в основном потоке
                /*runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.d(TAG, result);
                    }
                });*/
            }
        }).start();

        while (urlLink[0] == null){
            try {
                Thread.sleep(1000); // ожидание 10 секунд
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return urlLink[0];
    }



}
