package com.wr.unit.creator;

import java.io.File;

/**
 * Created by wangrui on 2015/5/12.
 */
public class CreatorPath implements Creator{
    private Context context;
    public CreatorPath(Context context) {
        this.context = context;
    }

    @Override
    public void create() {
        //JAVA
        File cp = new File( context.getPackEntityPath() );
        cp.mkdirs();
        cp = new File (context.getPackDao());
        cp.mkdirs();
        cp = new File (context.getPackServicePath());
        cp.mkdirs();
        cp = new File (context.getPackWebPath());
        cp.mkdirs();

        cp = new File (context.getJSPPath());
        cp.mkdirs();
        cp = new File( context.getDBPath() );
        cp.mkdirs();

        cp = new File( context.getCONFIGPath() );
        cp.mkdirs();

    }
}
