package pl.sda.lambda;


@FunctionalInterface
public interface Cons<T> {
    void apply(T a);

    default Cons<T> print(Cons<? super T> after){
        return (T t) -> { apply(t); after.apply(t); };
    }
}
