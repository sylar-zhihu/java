package 责任链;

import java.util.ArrayList;
import java.util.List;

public class FilterChain implements Filter {
    // 本身也是一个filter
    List<Filter> filters = new ArrayList<Filter>();

    public FilterChain addFilter(Filter f) {
        this.filters.add(f);
        return this;
    }

    public String doFilter(String str) {
        String r = str;
        for (Filter f : filters) {
            r = f.doFilter(r);
        }
        return r;
    }
}
