package org.masa.ayanoter;

import com.mysql.jdbc.Blob;
import com.sun.imageio.spi.InputStreamImageInputStreamSpi;
import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.codehaus.groovy.runtime.powerassert.SourceText;
import org.hibernate.engine.jdbc.BlobProxy;
import org.masa.ayanoter.Repositories.SubscriptionRepository;
import org.masa.ayanoter.Repositories.UserRepository;
import org.masa.ayanoter.models.Subscription;
import org.masa.ayanoter.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    SubscriptionRepository subscriptionRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public LayoutDialect layoutDialect() {
        return new LayoutDialect();
    }


    @Override
    public void run(String... strings) throws Exception {
        User user = new User();
        user.setLogin("Vasya");

        File file = new File("C:\\Users\\РС\\IdeaProjects\\TwitterMasa\\src\\main\\resources\\Cat.jpg");
        if (file.exists()) {
            System.out.println("Yeah");
            try {
                BufferedImage bufferedImage = ImageIO.read(file);
                ByteArrayOutputStream byteOutStream = new ByteArrayOutputStream();
                ImageIO.write(bufferedImage, "jpg", byteOutStream);
                user.setImage(BlobProxy.generateProxy(byteOutStream.toByteArray()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Nope");
        }
        userRepository.save(user);

/*        InputStream stream = user.getImage().getBinaryStream();
        File fileIn = new File("C:\\Users\\РС\\IdeaProjects\\TwitterMasa\\src" +
                "\\main\\resources\\templates\\home\\images\\"+ user.login + "_avatar.jpg");
        try(FileOutputStream outputStream = new FileOutputStream(fileIn)) {
            BufferedImage bufferedImage = ImageIO.read(stream);
            ImageIO.write(bufferedImage, "jpg", outputStream);
            System.out.println("Image file location: "+fileIn.getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }*/


        User user1 = new User();
        user1.setLogin("Petya");
        userRepository.save(user1);

        User user2 = new User();
        user2.setLogin("Pavel");
        userRepository.save(user2);

        Subscription s = new Subscription(user, user1);
        subscriptionRepository.save(s);
        Subscription s1 = new Subscription(user, user2);
        subscriptionRepository.save(s1);
    }
}