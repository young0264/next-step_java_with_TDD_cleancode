package nextstep.optional;

import java.util.Optional;

public class User {
    private String name;
    private Integer age;

    public static final int MIN_AGE = 30;
    public static final int MAX_AGE = 45;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public boolean matchName(String name) {
        return this.name.equals(name);
    }

    public static boolean ageIsInRange1(User user) {
        boolean isInRange = false;

        if (user != null && user.getAge() != null
                && (user.getAge() >= MIN_AGE
                && user.getAge() <= MAX_AGE)) {
            isInRange = true;
        }
        return isInRange;
    }

    public static boolean ageIsInRange2(User user) {
//        System.out.println(user.getName());
        return Optional.ofNullable(user)
                .map(User::getAge)
                .filter(User::isAgeInRange)
                .isPresent();
    }

    private static boolean isAgeInRange(Integer age) {
        return age != null && age >= MIN_AGE && age <= MAX_AGE;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((age == null) ? 0 : age.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (age == null) {
            if (other.age != null)
                return false;
        } else if (!age.equals(other.age))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }
}
