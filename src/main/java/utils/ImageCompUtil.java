package utils;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.File;
import java.io.IOException;

public class ImageCompUtil {

    public static void main(String[] args) {
        File file1 = new File("C:\\Users\\Yuriy\\IdeaProjects\\image-comparison\\images\\image1.png");
        File file2 = new File("C:\\Users\\Yuriy\\IdeaProjects\\image-comparison\\images\\image2.png");
        File file3 = new File("C:\\Users\\Yuriy\\IdeaProjects\\image-comparison\\images\\image1.png");
        System.out.println(ImageCompUtil.compareImage(file1,file2));
        System.out.println(ImageCompUtil.compareImage(file1,file3));
    }

    public static boolean compareImage(File file1, File file2){
        try {
            BufferedImage BImage1 = ImageIO.read(file1);
            DataBuffer DBImage1 = BImage1.getData().getDataBuffer();
            BufferedImage BImage2 = ImageIO.read(file2);
            DataBuffer DBImage2 = BImage2.getData().getDataBuffer();
            int sizeImage1 = DBImage1.getSize();
            int sizeImage2 = DBImage2.getSize();
            int el = DBImage1.getElem(1);
            if (sizeImage1 == sizeImage2) {
                for (int i = 0; i < sizeImage1; i++)
                    if (DBImage1.getElem(i) != DBImage2.getElem(i)) return false;
            return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }
}
