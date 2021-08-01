package com.softserve;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.testng.annotations.Test;

import com.softserve.entity.User;

import io.github.sskorol.core.DataSupplier;
import io.github.sskorol.data.JsonReader;
import io.github.sskorol.data.TestDataReader;
import one.util.streamex.EntryStream;
import one.util.streamex.StreamEx;

public class DataSupplier_TestingDiffVar {

    @DataSupplier
    public Stream<User> getData() {
        return Stream.of(new User("Petya", "password2"), 
                         new User("Virus Petya", "password3"), 
                         new User("Mark", "password1"))
                .filter(u -> !u.getName().contains("Virus"));
    }

    @Test(dataProvider = "getData")
    public void shouldSupplyStreamData(final User user) {

        System.out.println("User = " + user.getName() + "; password = " + user.getPassword());
    }

    @DataSupplier(transpose = true)
    public List<User> getExtractedData() {
        return StreamEx.of(new User("username1", "password1"), new User("username2", "password2")).toList();
    }

    @Test(dataProvider = "getExtractedData")
    public void shouldSupplyExtractedListData(final User... users) {
        Arrays.stream(users).forEach(System.out::println);
    }

    @DataSupplier(flatMap = true)
    public Map<Integer, String> getInternallyExtractedMapData() {
        return EntryStream.of(Arrays.asList("user3", "user4")).toMap();
    }

    @Test(dataProvider = "getInternallyExtractedMapData")
    public void supplyInternallyExtractedMapData(final Integer key, final String value) {
        System.out.println("Key = " + key + "; value = " + value);
    }
    
    @DataSupplier
    public StreamEx<User> getUsers() {
        return TestDataReader.use(JsonReader.class).withTarget(User.class).withSource("users.json").read();
    }
    
    @Test(dataProvider = "getUsers")
    public void shouldSupplyStreamUsers(final User user) {

        System.out.println("User = " + user.getName() + "; password = " + user.getPassword());
    }
    
    @DataSupplier
    public StreamEx<User> getUsers2() {
        return TestDataReader.use(JsonReader.class).withTarget(User.class).read();
    }
    
    @Test(dataProvider = "getUsers2")
    public void shouldSupplyStreamUsers2(User user) {

        System.out.println("User = " + user.getName() + "; password = " + user.getPassword());
    }
}
