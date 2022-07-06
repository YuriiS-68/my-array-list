package technical_interview.books_shelf;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BooksShelf {
    //на вход получаю список названий книг
    //распределить книги так, чтобы на каждой полке было примерно одинаковое кол-во книг
    //книги должны быть отсортированы по алфавиту с первой и до последней полки
    //количество полок константное 5 штук
    //вернуть книги распределенные по полкам

    public static void main(String[] args) {

        getShelvesOfBooks(getBooks());

    }

    private static List<ArrayList<Book>> getShelvesOfBooks(List<Book> books){
        List<Book> sortedBooks = books.stream()
                                .sorted(Comparator.comparing(Book::getName))
                                .collect(Collectors.toList());

        List<ArrayList<Book>> shelves = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ArrayList<Book> shelf = new ArrayList<>();
            shelves.add(shelf);
        }

        int indexSortedBook = 0;
        int indexShelf = 0;
        while (indexSortedBook < sortedBooks.size()){
            int perShelf = getBooksPerShelf(sortedBooks.size() - indexSortedBook, shelves.size() - indexShelf);
            for (int i = 0; i < perShelf; i++) {
                shelves.get(indexShelf).add(sortedBooks.get(indexSortedBook));
                indexSortedBook++;
            }
            indexShelf++;
        }

        int index = 1;
        for (ArrayList<Book> shelf : shelves) {
            System.out.println("shelf" + index + " = " + shelf);
            index++;
        }
        return shelves;
    }

    private static int getBooksPerShelf(int booksSize, int shelvesSize){
        int perShelf = booksSize / shelvesSize;
        if (perShelf * shelvesSize < booksSize){
            perShelf++;
        }
        return perShelf;
    }

    private static Book getFirstSortedBook(List<Book> books){
        return books.stream().min(Comparator.comparing(Book::getName)).get();
    }

    private static List<Book> getBooks(){
        Book book1 = new Book("Игра престолов");
        Book book2 = new Book("Том Сойер");
        Book book3 = new Book("Война и мир");
        Book book4 = new Book("Мастер и Маргарита");
        Book book5 = new Book("Java в действии");
        Book book6 = new Book("Сказки");
        Book book7 = new Book("Повесть о настоящем человеке");
        Book book8 = new Book("Аэропорт");
        Book book9 = new Book("Собака Баскервилей");
        Book book10 = new Book("Цитадель");
        Book book11 = new Book("Вождь краснокожих");
        Book book12 = new Book("Машина времени");
        Book book13 = new Book("Дон Кихот");
        Book book14 = new Book("Белый клык");
        Book book15 = new Book("Три мушкетера");
        Book book16 = new Book("Пармская обитель");

        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);
        books.add(book6);
        books.add(book7);
        books.add(book8);
        books.add(book9);
        books.add(book10);
        books.add(book11);
        books.add(book12);
        books.add(book13);
        /*books.add(book14);
        books.add(book15);
        books.add(book16);*/

        return books;
    }
}
