package uz.rcs.fragments.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import uz.rcs.fragments.models.Note;

public class MyShared {
    private SharedPreferences sharedPreferences;
    private Gson gson;

    public MyShared(Context context, Gson gson) {
        this.sharedPreferences = context.getSharedPreferences("PREFS_NAME", Context.MODE_PRIVATE);
        this.gson = gson;
    }
// Note ni list korinishida saqlaydi.
    public <T> void putList(String key, List<T> list) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, gson.toJson(list));
        editor.apply();
    }
// get list Note lar listini bizga olib beradi.
    public <T> List<T> getList(String key, Class<T> clazz) {
        String data = sharedPreferences.getString(key, null);

        Type typeOfT = new TypeToken<List<Note>>() {
        }.getType();

        return gson.fromJson(data, typeOfT);
    }
}
