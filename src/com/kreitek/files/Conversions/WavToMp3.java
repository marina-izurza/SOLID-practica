package com.kreitek.files.Conversions;

import com.kreitek.files.File;
import com.kreitek.files.FileSystemItem;
import com.kreitek.files.error.InvalidFileFormatException;

public class WavToMp3 extends File implements IToMp3 {

    public WavToMp3(FileSystemItem parent, String name) {
        super(parent, name);
    }

    @Override
    public FileSystemItem convertWavToMp3(){
        if (!"wav".equalsIgnoreCase(getExtension())) {
            throw new InvalidFileFormatException("El fichero debe ser wav");
        }

        int indexOfLastDot = name.lastIndexOf(".");
        String nameWithoutExtension = name;
        if (indexOfLastDot > 0) {
            nameWithoutExtension = name.substring(0, indexOfLastDot);
        }
        String newFileName = nameWithoutExtension + ".mp3";
        FileSystemItem result = new File(parent, newFileName);
        result.open();
        // Lógica de conversión de wav a mp3. Se lee de este fichero y se escribe en result
        result.close();
        return result;
    }
}
