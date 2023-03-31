package com.kreitek.files.Conversions;

import com.kreitek.files.File;
import com.kreitek.files.FileSystemItem;
import com.kreitek.files.error.InvalidFileFormatException;

public class Mp3ToWav extends File implements IToWav {

    public Mp3ToWav(FileSystemItem parent, String name) {
        super(parent, name);
    }

    @Override
    public FileSystemItem convertMp3ToWav(){
        if (!"mp3".equalsIgnoreCase(getExtension())) {
            throw new InvalidFileFormatException("El fichero debe ser mp3");
        }

        int indexOfLastDot = name.lastIndexOf(".");
        String nameWithoutExtension = name;
        if (indexOfLastDot > 0) {
            nameWithoutExtension = name.substring(0, indexOfLastDot);
        }
        String newFileName = nameWithoutExtension + ".wav";
        FileSystemItem result = new File(parent, newFileName);
        result.open();
        // Lógica de conversión de mp3 a wav. Se lee de este fichero y se escribe en result
        result.close();
        return result;
    }

}
