package 责任链;

public interface Filter {
    // 实现了这个接口，就能处理字符串
    String doFilter(String str);
}
