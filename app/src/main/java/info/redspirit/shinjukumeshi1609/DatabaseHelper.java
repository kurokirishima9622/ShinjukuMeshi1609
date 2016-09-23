package info.redspirit.shinjukumeshi1609;

/**
 * Created by rj on 16/09/21.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.content.Context;
import android.content.res.AssetManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    /* データベース名 */
    private final static String DB_NAME = "shinjukumeshi";
    /* データベースのバージョン
    ここを変えるとデータベースを 作りなおす*/
    private final static int DB_VER = 2;
    /* コンテキスト */
    private Context mContext;

    /**
     * コンストラクタ
     */
    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VER);
        mContext = context;
    }

    /**
     * データベースが作成された時に呼ばれます。
     * assets/sql/create内に定義されているsqlを実行します。
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            execSql(db,"sql/create");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * データベースをバージョンアップした時に呼ばれます。
     * assets/sql/drop内に定義されているsqlを実行します。
     * その後onCreate()メソッドを呼び出します。
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        try {
            execSql(db, "sql/drop");
        } catch (IOException e) {
            e.printStackTrace();
        }
        onCreate(db);
    }

    /**
     * 引数に指定したassetsフォルダ内のsqlを実行します。
     * @param db データベース
     * @param assetsDir assetsフォルダ内のフォルダのパス
     * @throws IOException
     */
    private void execSql(SQLiteDatabase db,String assetsDir) throws IOException {
        AssetManager as = mContext.getResources().getAssets();
        try {
            String files[] = as.list(assetsDir);
            for (int i = 0; i < files.length; i++) {
                String str = readFile(as.open(assetsDir + "/" + files[i]));
                for (String sql: str.split("/")){
                    db.execSQL(sql);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * ファイルから文字列を読み込みます。
     * @param is
     * @return ファイルの文字列
     * @throws IOException
     */
    private String readFile(InputStream is) throws IOException{
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(is,"utf8"));

            StringBuilder sb = new StringBuilder();
            String str;
            while((str = br.readLine()) != null){
                sb.append(str +"\n");
            }
            return sb.toString();
        } finally {
            if (br != null) br.close();
        }
    }

}
