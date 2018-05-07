package spring;

public interface BeanFactory {
    /**
     * 作者：
     * 用途说明：通过ID得到对象
     * @param id
     * @return
     */
    public Object getBean(String id);
}
