package p.lagodzinski.tree.e.api;

import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import p.lagodzinski.tree.e.dto.MathResult;
import p.lagodzinski.tree.e.services.AddNumberService;
import p.lagodzinski.tree.e.services.DivNumberService;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@RestController
@RequestMapping("/api")
@Validated
public class MathApiController {

    private final AddNumberService addNumberService;
    private final DivNumberService divNumberService;

    public MathApiController(final AddNumberService addNumberService, final DivNumberService divNumberService) {
        this.addNumberService = addNumberService;
        this.divNumberService = divNumberService;
    }

    @PostMapping(path = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public MathResult add(@Valid @NotEmpty @RequestParam("val1") final double val1, @Valid @NotEmpty @RequestParam("val2") final double var2) {
        return addNumberService.calculate(val1, var2);
    }

    @GetMapping(path = "/div", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public MathResult div(@Valid @NotEmpty @RequestParam("val1") final double val1, @Valid @NotEmpty @RequestParam("val2") final double var2) {
        return divNumberService.calculate(val1, var2);
    }
}
