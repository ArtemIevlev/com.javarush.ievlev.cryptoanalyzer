package util;

public class Constants {

    private static final String rus = "абвгдеёжзиклмнопрстуфхцчшщьыъэюя";
    private static final String cypher = "0123456789";
    private static final String z = ",.?!/@#$%^&*()_-+={}[]";
    public static final char[] ALPHABET = (rus + z + cypher).toCharArray();
}
