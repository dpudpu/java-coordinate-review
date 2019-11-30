package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TriangleTest {
    final PointGroup pointGroup = PointGroup.of(List.of(Point.of(10, 10), Point.of(14, 15), Point.of(20, 8)));
    final Triangle triangle = Triangle.of(pointGroup);

    @Test
    void Points_size_3이_아닌_경우_예외처리() {
        final PointGroup pointGroup = PointGroup.of(List.of(Point.of(10, 10), Point.of(14, 15)));
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Triangle.of(pointGroup));

        assertThat(exception.getMessage()).isEqualTo(Triangle.POINTS_SIZE_NOT_MATCH_EXCEPTION_MESSAGE);
    }

    @Test
    void sizeTest() {
        assertThat(triangle.size()).isEqualTo(Triangle.SIZE_OF_POINTS);
    }

    @Test
    void areaTest() {
        final double expected = 29.0;

        assertThat(triangle.area()).isEqualTo(expected, offset(0.099));
    }
}