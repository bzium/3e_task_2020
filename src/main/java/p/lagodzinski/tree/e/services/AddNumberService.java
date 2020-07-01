package p.lagodzinski.tree.e.services;

import org.springframework.stereotype.Service;
import p.lagodzinski.tree.e.dto.MathResult;

import java.math.BigDecimal;

@Service
public class AddNumberService {
    public MathResult calculate(final double first, final double second) {
        final BigDecimal firstAsBigDecimal = BigDecimal.valueOf(first);
        final BigDecimal secondAsBigDecimal = BigDecimal.valueOf(second);
        return new MathResult(firstAsBigDecimal.add(secondAsBigDecimal).doubleValue());
    }
}
