package hw8_22001622_PhamVanNam.geeksForGeeks;

public class exc8 {
    int color;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        // Code here
        if (image[sr][sc]==newColor) return image;
        color = image[sr][sc];
        fill(image, sr, sc, newColor);
        return image;
    }
    public void fill(int[][] image, int sr,int sc, int newColor) {
        if (sr<0||sc<0||sr>=image.length||sc>=image[0].length||image[sr][sc]!=color) return;
        image[sr][sc]=newColor;
        fill(image,sr-1, sc, newColor);
        fill(image,sr, sc+1, newColor);
        fill(image,sr+1, sc, newColor);
        fill(image,sr, sc-1, newColor);
    }
}
