package ig.core.android.util;

import android.util.Log;

/****
 *
 * Created by ORN TONY on 01/01/19.
 *
 */

public class Logger {
    private final static boolean LOG = true;

    public static void startLog(String tag,String ResultLog){
        if(LOG){
            Log.d(tag, ResultLog);
        }
    }
}
