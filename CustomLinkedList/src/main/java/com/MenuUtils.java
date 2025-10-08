package com;

import java.util.List;

public class MenuUtils {
    public static String getHeader(final String title, final List<String> options) {

        StringBuilder header = new StringBuilder("\n\n[" + title + "]\n\n");

        for (int i = 0; i < options.size(); i++) {
            header.append(i + 1).append(") ").append(options.get(i)).append(".\n");
        }

        header.append("0) Exit.\n").append("\nChoose: ");

        return header.toString();
    }
}
