package br.eti.victorsoares.aula04.Util;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * http://pt.stackoverflow.com/questions/44092/como-salvar-recuperar-imagem-na-mem%C3%B3ria-no-android
 */
public class Imagem {

    Context context;

    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    public void saveArrayToInternalStorage(String fileName, byte[] imagem){
        try{
            FileOutputStream fos = context.openFileOutput(fileName, Context.MODE_PRIVATE);
            fos.write(imagem);
            fos.close();
        }catch (IOException e) {
            Log.w("InternalStorage", "Error writing", e);
        }
    }

    public void saveArrayToSDCard(String fileName, byte[] imagem){
        File path = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File file = new File(path, fileName);
        try{
            OutputStream os = new FileOutputStream(file);
            os.write(imagem);
            os.close();
        } catch (IOException e) {
            Log.w("ExternalStorage", "Error writing", e);
        }
    }
}
