package coordinate.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {
    List<Point> pointList = new ArrayList<>();

    @BeforeEach
    void 사각형_Points_초기화() {
        pointList.add(new Point(3, 3));
        pointList.add(new Point(3, 6));
        pointList.add(new Point(6, 3));
        pointList.add(new Point(6, 6));
    }

    @Test
    void 사각형_넓이_구하기() {
        Rectangle rectangle = new Rectangle(pointList);
        Assertions.assertThat(rectangle.pointResult()).isEqualTo(9);
    }

    @Test
    void Figure_Result() {
        assertThat(new Rectangle(pointList).getFigureResult()).isEqualTo("사각형 넓이는 " + 9.0);
    }

}