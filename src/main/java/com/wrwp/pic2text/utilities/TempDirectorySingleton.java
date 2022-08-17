package com.wrwp.pic2text.utilities;

import java.io.IOException;
import java.nio.file.Files;

public class TempDirectorySingleton {
    private static volatile TempDirectorySingleton instance = null;
    private final String tmpdir;

    private TempDirectorySingleton() throws IOException {
        this.tmpdir = Files.createTempDirectory("tempImages").toFile().getAbsolutePath();
    }

    public static TempDirectorySingleton getInstance() throws IOException {
        if(instance == null){
            instance = new TempDirectorySingleton();
        }
        return instance;
    }

    public String getTmpdir() {
        return tmpdir;
    }
}
