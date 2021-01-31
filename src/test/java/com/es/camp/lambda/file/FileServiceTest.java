package com.es.camp.lambda.file;

import com.es.camp.effective_skill.lambda.file.FileService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class FileServiceTest {

    @Test
    public void fileHandle() throws IOException {
        String url = "/Users/chenjun/Work/projects/" +
                "JavaCamp/src/test/java/com/es/camp/" +
                "lambda/file/FileServiceTest.java";

        FileService.fileHandle(url, fileContent -> System.out.println(fileContent));
    }



}
