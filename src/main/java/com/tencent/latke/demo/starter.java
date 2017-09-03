package com.tencent.latke.demo;

import org.b3log.latke.Latkes;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

import java.io.File;

/**
 * Created by ansonwen on 2017/8/30.
 */
public class starter {
    public static void main(String[] args) {
        Latkes.setScanPath("com.tencent.latke.demo");
        Latkes.initRuntimeEnv();

        String classPath=ClassLoader.getSystemResource("").getPath();
        String webappDirLocation=classPath.replace("target/classes/","src/main/webapp/");
        final File file=new File(webappDirLocation);
        if (!file.exists()){
            webappDirLocation=".";
        }
        final Server server=new Server(Integer.valueOf(Latkes.getServerPort()));
        final WebAppContext root=new WebAppContext();
        root.setParentLoaderPriority(true);
        root.setContextPath("/");
        root.setDescriptor(webappDirLocation+"/WEB-INF/web.xml");
        root.setResourceBase(webappDirLocation);
        server.setHandler(root);

        try {
            server.start();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
