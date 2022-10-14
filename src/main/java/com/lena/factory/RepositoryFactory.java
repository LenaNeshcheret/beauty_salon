package com.lena.factory;

import com.lena.repositories.ClientRepositoryImpl;
import com.lena.repositories.FeedbackRepositoryImpl;
import com.lena.repositories.MasterRepositoryImpl;
import com.lena.repositories.RecordRepositoryImpl;
import com.lena.services.ClientRepository;

public class RepositoryFactory {


    public static <T> T create(String str, Class<T> clsass) {
        switch (str) {
            case ("client"):
                return (T) new ClientRepositoryImpl();
            case ("master"):
                return (T) new MasterRepositoryImpl();
            case ("record"):
                return (T) new RecordRepositoryImpl();
            case ("feedback"):
                return (T) new FeedbackRepositoryImpl();
            default :
                throw new IllegalArgumentException();
        }
    }
}
