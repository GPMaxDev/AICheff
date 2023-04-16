// layter  play whith accsess to this clkass

package com.gmail.dev.max.aicheff;

import android.os.AsyncTask;
import android.util.Log;

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

        try {
            Thread.sleep(10000); // ожидание 10 секунд
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return urlLink[0];
    }



}
