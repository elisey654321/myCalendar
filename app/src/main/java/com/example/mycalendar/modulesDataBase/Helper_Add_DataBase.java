package com.example.mycalendar.modulesDataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import com.example.mycalendar.classesDataBases.taskList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Helper_Add_DataBase extends SQLiteOpenHelper {

    List<String> CREATE_TABLE = getSQL_query_array();

    public static String DB_NAME = "DB_CalendarProject.db";
    Context mContext;

    public Helper_Add_DataBase(@Nullable Context context, int version) {
        super(context, DB_NAME, null, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        for( String oneItem : CREATE_TABLE ) {
            sqLiteDatabase.execSQL(oneItem);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        if (i > 0){
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS taskList");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS status");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS taskStatus");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS scheduleList");

            onCreate(sqLiteDatabase);
        }
    }

    private List<String> getSQL_query_array(){

        List<String> array = new ArrayList<String>();

        String query1 = "CREATE TABLE taskList (\n" +
                        "    Name char(100),\n" +
                        "    id INTEGER PRIMARY KEY);";
        String query2 = "CREATE TABLE status (\n" +
                        "    Name char(100),\n" +
                        "    id INTEGER PRIMARY KEY);";
        String query3 = "CREATE TABLE taskStatus (\n" +
                        "    idTask INTEGER NOT NULL,    \n" +
                        "    idStatus INTEGER NOT NULL,\n" +
                        "    FOREIGN KEY (idTask) REFERENCES taskList(id),\n" +
                        "    FOREIGN KEY (idStatus) REFERENCES status(id));";
        String query4 = "CREATE TABLE scheduleList (\n" +
                        "    hourDay INTEGER,\n" +
                        "    idTask INTEGER NOT NULL,    \n" +
                        "    idStatus INTEGER NOT NULL,\n" +
                        "    FOREIGN KEY (idTask) REFERENCES taskList(id),\n" +
                        "    FOREIGN KEY (idStatus) REFERENCES status(id));";

        array.add(query1);
        array.add(query2);
        array.add(query3);
        array.add(query4);

        return array;
    }

    public void createTask(SQLiteDatabase db, taskList task){

        boolean answer;

        ContentValues cv = new ContentValues();
        cv.put("Name",task.Name);

        long result = db.insert("taskList",null,cv);

        if(result == -1)
            answer = false;
        else
            answer = true;

    }

    public List<taskList> getTaskList(SQLiteDatabase db, List<taskList> task_list) {
        Cursor result = db.rawQuery("SELECT * FROM taskList",null);
        task_list.add(new taskList("column",0));
        while (result.moveToNext()){
            task_list.add(new taskList(result.getString(0),result.getInt(1)));
        }

        return task_list;
    }
}
