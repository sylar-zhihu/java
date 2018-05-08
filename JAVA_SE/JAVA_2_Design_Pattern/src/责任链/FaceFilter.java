package 责任链;

public class FaceFilter implements Filter {
    // 替换笑脸

    @Override
    public String doFilter(String str) {
        return str.replace(":)", "^V^");
    }

}
