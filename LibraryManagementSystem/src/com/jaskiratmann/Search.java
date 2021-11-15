package com.jaskiratmann;

import java.util.List;

public interface Search {
    <T> List<Book> performSearch(T type);
}
