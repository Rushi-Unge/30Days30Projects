package MoodPlay.src;

import java.util.*;

public class MoodPlay {

    // ANSI Color Codes for better CLI styling
    static final String RESET = "\u001B[0m";
    static final String GREEN = "\u001B[32m";
    static final String YELLOW = "\u001B[33m";
    static final String CYAN = "\u001B[36m";
    static final String PURPLE = "\u001B[35m";
    static final String RED = "\u001B[31m";
    static final String BOLD = "\u001B[1m";

    enum Mood {
        HAPPY, SAD, ENERGETIC, ROMANTIC, CHILL, DEVOTIONAL
    }

    static Map<Mood, List<String>> hindiSongs = new HashMap<>();
    static Map<Mood, List<String>> marathiSongs = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        initializeSongs();

        printHeader(" MoodPlay - Hindi & Marathi Song Recommender ");

        System.out.println(YELLOW + "Select your current mood:" + RESET);
        for (Mood mood : Mood.values()) {
            System.out.println(" " + BOLD + mood.name().toLowerCase() + RESET);
        }

        System.out.print("\n" + CYAN + "Enter your mood: " + RESET);
        String moodInput = sc.nextLine().trim().toUpperCase();

        System.out.print(CYAN + "Choose language (hindi/marathi): " + RESET);
        String lang = sc.nextLine().trim().toLowerCase();

        try {
            Mood mood = Mood.valueOf(moodInput);
            List<String> songList = (lang.equals("hindi")) ? hindiSongs.get(mood) : marathiSongs.get(mood);

            if (songList != null && !songList.isEmpty()) {
                System.out.println("\n" + GREEN + " Suggested song for your " + mood.toString().toLowerCase() + " mood:" + RESET);
                Random rand = new Random();
                System.out.println(" "+BOLD + PURPLE + songList.get(rand.nextInt(songList.size())) + RESET);
            } else {
                System.out.println(RED + " No songs found for this mood/language." + RESET);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(RED + " Invalid mood. Please choose from the listed moods." + RESET);
        }

        printFooter();
        sc.close();
    }

    public static void printHeader(String title) {
        System.out.println("\n" + CYAN + "==========================================" + RESET);
        System.out.println(BOLD + " " + title + RESET);
        System.out.println(CYAN + "==========================================\n" + RESET);
    }

    public static void printFooter() {
        System.out.println("\n" + GREEN + "Thank you for using MoodPlay! Stay musical! 🎶" + RESET);
    }

    static void initializeSongs() {
        hindiSongs.put(Mood.HAPPY, Arrays.asList(
                "Zinda - Bhaag Milkha Bhaag",
                "Gallan Goodiyan - Dil Dhadakne Do",
                "Kar Gayi Chull - Kapoor & Sons",
                "Ude Dil Befikre - Befikre",
                "Cutiepie - Ae Dil Hai Mushkil",
                "Nashe Si Chadh Gayi - Befikre",
                "The Breakup Song - Ae Dil Hai Mushkil",
                "Bom Diggy Diggy - Sonu Ke Titu Ki Sweety",
                "Tareefan - Veere Di Wedding",
                "London Thumakda - Queen",
                "Sweety Tera Drama - Bareilly Ki Barfi",
                "Proper Patola - Namaste England",
                "Morni Banke - Badhaai Ho",
                "Aankh Marey - Simmba",
                "Saturday Saturday - Humpty Sharma Ki Dulhania"
        ));

        hindiSongs.put(Mood.SAD, Arrays.asList(
                "Channa Mereya - Ae Dil Hai Mushkil",
                "Agar Tum Saath Ho - Tamasha",
                "Tadap Tadap - Hum Dil De Chuke Sanam",
                "Kabira - Yeh Jawaani Hai Deewani",
                "Hamari Adhuri Kahani - Title Track",
                "Tera Yaar Hoon Main - Sonu Ke Titu Ki Sweety",
                "Jeene Bhi De - Dil Sambhal Ja Zara",
                "Phir Le Aaya Dil - Barfi!",
                "Tu Jaane Na - Ajab Prem Ki Ghazab Kahani",
                "Bhula Dena - Aashiqui 2",
                "Yaad Hai Na - Raaz Reboot",
                "Lo Maan Liya - Raaz Reboot",
                "Judaai - Badlapur",
                "Darmiyaan - Jodi Breakers",
                "Main Rahoon Ya Na Rahoon - Emraan Hashmi"
        ));

        hindiSongs.put(Mood.ENERGETIC, Arrays.asList(
                "Malhari - Bajirao Mastani",
                "Jai Jai Shivshankar - War",
                "Ghungroo - War",
                "Bang Bang - Bang Bang",
                "Jumme Ki Raat - Kick",
                "Sher Aaya Sher - Gully Boy",
                "Ziddi Dil - Mary Kom",
                "Bala - Housefull 4",
                "Sultan - Title Track",
                "Tera Baap Aaya - Commando 3",
                "Apna Time Aayega - Gully Boy",
                "Tunak Tunak Tun - Daler Mehndi",
                "Desi Look - Ek Paheli Leela",
                "Kamariya - Stree",
                "Saudagar Sauda Kar - Saudagar"
        ));

        hindiSongs.put(Mood.ROMANTIC, Arrays.asList(
                "Tum Hi Ho - Aashiqui 2",
                "Raabta - Agent Vinod",
                "Tum Mile - Tum Mile",
                "Janam Janam - Dilwale",
                "Pee Loon - Once Upon A Time In Mumbaai",
                "Tera Hone Laga Hoon - Ajab Prem Ki Ghazab Kahani",
                "Kaun Tujhe - M.S. Dhoni",
                "Jeene Laga Hoon - Ramaiya Vastavaiya",
                "Sun Saathiya - ABCD 2",
                "Gerua - Dilwale",
                "Shayad - Love Aaj Kal",
                "Raatan Lambiyan - Shershaah",
                "Pal - Jalebi",
                "Khairiyat - Chhichhore",
                "Kesariya - Brahmastra"
        ));

        hindiSongs.put(Mood.CHILL, Arrays.asList(
                "Ilahi - Yeh Jawaani Hai Deewani",
                "Phir Se Ud Chala - Rockstar",
                "Shaam - Aisha",
                "Safarnama - Tamasha",
                "Hairat - Anjaana Anjaani",
                "Dil Dhadakne Do - ZNMD",
                "Aazaadiyan - Udaan",
                "Khwaabon Ke Parindey - ZNMD",
                "Patakha Guddi - Highway",
                "Yun Hi - Tanu Weds Manu",
                "Zehnaseeb - Hasee Toh Phasee",
                "Bekhayali - Kabir Singh",
                "Dil Diyan Gallan - Tiger Zinda Hai",
                "Ae Watan - Raazi",
                "Manja - Kai Po Che"
        ));

        hindiSongs.put(Mood.DEVOTIONAL, Arrays.asList(
                "Shree Hanuman Chalisa",
                "Shiv Tandav Stotram",
                "Achyutam Keshavam",
                "Mere Ghar Ram Aaye Hain - Jubin Nautiyal",
                "Shivoham - Baahubali",
                "Jai Jai Ram Krishna Hari",
                "Raghupati Raghav Raja Ram",
                "Om Jai Jagdish Hare",
                "Hanuman Ashtak",
                "Jai Ambe Gauri",
                "Bhaja Govindam",
                "Durga Chalisa",
                "Vishnu Sahasranamam",
                "Shiv Bhola Bhandari",
                "Mann Mohana - Jodhaa Akbar"
        ));

        marathiSongs.put(Mood.HAPPY, Arrays.asList(
                "Hi Chaal Turu Turu - Jatra",
                "Kombdi Palali - Jatra",
                "Zingaat - Sairat",
                "Sairat Zaala Ji - Sairat",
                "Apsara Aali - Natarang",
                "Dhagala Lagli Kala - Bot Lavin Tithe Gudgulya",
                "Wajle Ki Baara - Natarang",
                "Majha Hoshil Ka - Ajay-Atul",
                "Chimbh Bhijalele - Timepass",
                "Jhingat 2.0 - Rinku Rajguru",
                "Chand Matla - Aga Bai Arechya",
                "Tik Tik Vajate - Timepass 2",
                "Mala Ved Lagale - Timepass",
                "Ye Go Ye Maina - Duniyadari",
                "Navin Popat Ha - Boyz"
        ));

        marathiSongs.put(Mood.SAD, Arrays.asList(
                "Sairat Zaala Ji - Sairat",
                "Saajana - Duniyadari",
                "Tuzya Vina - Fandry",
                "Kadhi Tu - Timepass 2",
                "Jeev Rangala - Lai Bhaari",
                "Shwaas - Title Song",
                "Man Mandira - Katyar Kaljat Ghusali",
                "Man He Vede - Natsamrat",
                "Gaarva - Milind Ingle",
                "Olya Sanjveli - Katyar Kaljat Ghusali",
                "Mee Sindhutai Sapkal - Title Track",
                "Bai Vadyavar Ya - Classmates",
                "Yaara - Boyz 2",
                "Naav Motha Lakshat Naahi - Killa",
                "Manatlya Manat - Swaas"
        ));

        marathiSongs.put(Mood.ENERGETIC, Arrays.asList(
                "Zingaat - Sairat",
                "Kombdi Palali - Jatra",
                "Wajle Ki Baara - Natarang",
                "Apsara Aali - Natarang",
                "Chal Turu Turu - Jatra",
                "Dhagala Lagli Kala - Duniya",
                "Bai Wadyavar Ya - Classmates",
                "Pinga - Bajirao Mastani",
                "Jingalaala - Lai Bhaari",
                "Gondhal Mandila - Natarang",
                "Zhala Bobhata - Timepass 3",
                "Lagnalu - Boyz",
                "Popat - Duniyadari",
                "Morya Morya - Uladhaal",
                "Baila Dance - Aga Bai Arechya"
        ));

        marathiSongs.put(Mood.ROMANTIC, Arrays.asList(
                "Sairat Zaala Ji - Sairat",
                "Saajana - Duniyadari",
                "Tuzya Vina - Fandry",
                "Kadhi Tu - Timepass 2",
                "Premachi Gaani - Classmates",
                "Tula Pahata - Timepass 2",
                "Man Mandira - Katyar Kaljat Ghusali",
                "Shwaas - Title Song",
                "He Deva - Ajay-Atul",
                "Man He Vede - Natsamrat",
                "Yeh Re Yeh Re Paisa - Title Song",
                "Navri Mile Navryala - Mumbai Pune Mumbai",
                "Tik Tik Vajate - Timepass 2",
                "Manatlya Manat - Swaas",
                "Gaarva - Milind Ingle"
        ));

        marathiSongs.put(Mood.CHILL, Arrays.asList(
                "Gaarva - Milind Ingle",
                "Tula Pahata - Timepass 2",
                "Shwaas - Title Song",
                "Olya Sanjveli - Katyar Kaljat Ghusali",
                "Kadhi Tu - Timepass 2",
                "Sairat Zaala Ji - Sairat",
                "Man Mandira - Katyar Kaljat Ghusali",
                "Chimbh Bhijalele - Timepass",
                "Tuzya Vina - Fandry",
                "Mee Sindhutai Sapkal - Title Track",
                "Premachi Gaani - Classmates",
                "Tik Tik Vajate - Timepass 2",
                "Yeh Re Yeh Re Paisa - Title Song",
                "Manatlya Manat - Swaas",
                "Gaarva 2 - Milind Ingle"
        ));

        marathiSongs.put(Mood.DEVOTIONAL, Arrays.asList(
                "Ganpati Bappa Morya - Traditional",
                "Omkar Swarupa - Swapnil Bandodkar",
                "Deva Tujhya Gabharyala - Various",
                "Sukhakarta Dukhaharta",
                "Jai Dev Jai Dev",
                "Bhakticha Mala - Haripath",
                "He Vithu Mauli - Ajay Gogavale",
                "Pandurang Ashtak",
                "Abhang Tukaram",
                "Jai Jai Ram Krishna Hari",
                "Vitthal Maza Leela - Adarsh Shinde",
                "Dehachi Tijori - Tukaram Gatha",
                "Chinmaya Sakal Hridaya - Samarth Ramdas",
                "Jayostute - Rashtrageet",
                "Vitthala Vitthala - Bhakti Geet"
        ));
    }
}
