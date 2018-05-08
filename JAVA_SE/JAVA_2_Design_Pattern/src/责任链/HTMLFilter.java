package 责任链;



public class HTMLFilter implements Filter {
    // 去除html标签
    @Override
    public String doFilter(String str) {
        // process the html tag <>
        String r = str.replace('<', '[').replace('>', ']');
        return r;
    }

}
