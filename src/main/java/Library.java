import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {
    public static Scanner scanner = new Scanner(System.in);

    //simulation of a database
    public static List <Book> library = new ArrayList<>();

    public static void listLibraryItems(List<Book> list){

        System.out.println("################################################################################");
        System.out.println("What do you want to list from the library?");
        System.out.println("1 - All items");
        System.out.println("2 - Novels");
        System.out.println("3 - Art Albums");
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice){
            case 1:
                for (Book book : list) {
                        System.out.println(book);
                        System.out.println("--------------------------------------------------------------------------------");
                }
                break;
            case 2:
                for (Book book : list) {
                    if (book instanceof Novel) {
                        System.out.println(book);
                        System.out.println("--------------------------------------------------------------------------------");
                    }
                }
                break;
            case 3:
                for (Book book : list) {
                    if (book instanceof ArtAlbum) {
                        System.out.println(book);
                        System.out.println("--------------------------------------------------------------------------------");
                    }
                }
                break;
            default:
                System.out.println("Invalid option!!");
        }
    }

    public static void addToLibrary(){
        String title;
        int pages;
        String novelType;
        String albumPaperQuality;

        System.out.println("################################################################################");
        System.out.println("What do you want to add to the library? ");
        System.out.println("1 - Novel");
        System.out.println("2 - Art Album");
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice){
            case 1 :
                System.out.println("################################################################################");
                System.out.println("Enter the title of the novel:");
                title = scanner.nextLine();
                System.out.println("Enter the number of pages of the novel:");
                pages = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter the type of the novel:");
                novelType = scanner.nextLine();
                library.add(new Novel(title, pages, novelType));
                System.out.println("Novel successfully added to the library!!!");
                break;
            case 2:
                System.out.println("################################################################################");
                System.out.println("Enter the title of the album:");
                title = scanner.nextLine();
                System.out.println("Enter the number of pages of the album:");
                pages = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter the paper quality of the album:");
                albumPaperQuality = scanner.nextLine();
                library.add(new ArtAlbum(title, pages, albumPaperQuality));
                System.out.println("Album successfully added to the library!!!");
                break;
            default:
                System.out.println("Invalid option!!");
        }
    }

    public static void removeFromLibrary(){
        final String itemToRemove;
        int initialNumberOfItems = library.size();

        System.out.println("################################################################################");
        System.out.println("What is the name of the item you want to remove from the library?");
        itemToRemove = scanner.nextLine();
        System.out.println(itemToRemove);
        library.removeIf(book -> (book.getTitle().compareTo(itemToRemove) == 0));

        if (initialNumberOfItems == library.size()){
            System.out.println("No item was removed f3rom the library. Please check the spelling!");
        } else if(initialNumberOfItems > library.size()){
            System.out.println("Item removed from the Library!!!");
        }
    }

    public static void main(String[] args) {
        //some default entries
        library.add( new Novel("De la bine la excelent", 156, "Dezvoltare personala"));
        library.add( new ArtAlbum("Album Foto", 23, "lucios"));

        System.out.println("################################################################################");
        System.out.println("Welcome to the Library!");
        System.out.println("################################################################################");
        System.out.println("What do you want to do?");
        System.out.println("1 - List the books from the library");
        System.out.println("2 - Add item to the library");
        System.out.println("3 - Remove item from the library");
        System.out.println("9 - Exit library");
        int option = Integer.parseInt(scanner.nextLine());

        while (option !=9){
            switch (option){
                case 1:
                    listLibraryItems(library);
                    break;
                case 2:
                    addToLibrary();
                    break;
                case 3:
                    removeFromLibrary();
                    break;
                default:
                    System.out.println("Invalid option!!");
            }

            System.out.println("################################################################################");
            System.out.println("What do you want to do now?");
            System.out.println("1 - List the books from the library; 2 - Add item to the library; 3 - Remove item from the library; 9 - Exit library");
            option = Integer.parseInt(scanner.nextLine());
        }
    }
}
