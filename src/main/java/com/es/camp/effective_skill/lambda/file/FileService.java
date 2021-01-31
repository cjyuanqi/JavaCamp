package com.es.camp.effective_skill.lambda.file;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileService {

    public static void fileHandle(String url, FileConsumer fileConsumer) throws IOException {

        File file = new File(url);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

        String line = null;
        StringBuilder stringBuilder = new StringBuilder();
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line+"\n");
        }

        fileConsumer.fileHandler(stringBuilder.toString());
    }
}
