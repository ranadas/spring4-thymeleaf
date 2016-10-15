package  com.rdas.gr

import com.rdas.testci.TestingConfiguration
import com.rdas.util.Transformer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration

//@WebAppConfiguration
//@IntegrationTest
@ContextConfiguration(classes = [TestingConfiguration])
class HelloSpockSpec extends spock.lang.Specification {


    @Autowired
    private Transformer transformer


    def "length of Spock's and his friends' names"() {
        expect:
        transformer != null
        name.size() == length

        where:
        name     | length
        "Spock"  | 5
        "Kirk"   | 4
        "Scotty" | 6
    }
}