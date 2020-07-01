import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import p.lagodzinski.tree.e.Application
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
class MathApiTest extends Specification {


    def VAL1_NAME = "val1"
    def VAL2_NAME = "val2"
    def API_DIV_ENDPOINT = "/api/div"

    @Autowired
    private MockMvc mockMvc

    def "Invoke /api/add endpoint and check if return correct value for correct parameters"() {
        given:
        def val1content = "0.1"
        def val2content = "0.2"
        expect:
        mockMvc.perform(
                post("/api/add")
                        .content(MediaType.APPLICATION_JSON_VALUE)
                        .param(VAL1_NAME, val1content)
                        .param(VAL2_NAME, val2content)
        ).andExpect(status().isOk())
                .andExpect(jsonPath("\$.result").value(0.3))
    }

    def "Invoke /api/div endpoint and check if return correct value for correct parameters"() {
        given:
        def val1content = "0.1"
        def val2content = "0.1"
        expect:
        mockMvc.perform(
                get(API_DIV_ENDPOINT)
                        .content(MediaType.APPLICATION_JSON_VALUE)
                        .param(VAL1_NAME, val1content)
                        .param(VAL2_NAME, val2content)
        ).andExpect(status().isOk())
                .andExpect(jsonPath("\$.result").value(1.0))
    }

    def "Invoke /api/div endpoint and check if return error struct for incorrect parameters"() {
        given:
        def val1content = "0.1"
        def val2content = "0.0"
        expect:
        mockMvc.perform(
                get(API_DIV_ENDPOINT)
                        .content(MediaType.APPLICATION_JSON_VALUE)
                        .param(VAL1_NAME, val1content)
                        .param(VAL2_NAME, val2content)
        ).andExpect(status().isBadRequest())
                .andExpect(jsonPath("\$.message").value("You can't divide by 0"))
    }
}