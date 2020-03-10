package com.utknl.katas

import spock.lang.Specification

class CreatePhoneNumberSpecs extends Specification {

    def kata = new CreatePhoneNumber()

    def "code wars test"() {
        expect:
        assert "(123) 456-7890" == kata.createPhoneNumber([1, 2, 3, 4, 5, 6, 7, 8, 9, 0] as int[])
        assert "(345) 456-7890" == kata.createPhoneNumber([3, 4, 5, 4, 5, 6, 7, 8, 9, 0] as int[])
    }

    def "array length should be 10"() {
        when:
        kata.createPhoneNumber(array as int[])
        then:
        thrown(Exception)
        where:
        array                                   | _
        [1, 2, 4, 5, 6, 7]                      | _
        [1, 2, 4, 5, 6, 7, 3, 4, 5, 6, 6, 7, 2] | _
        [1]                                     | _
        [1, 2, 4, 5, 6, 7]                      | _
    }

    def "it should return the first three number"() {
        when:
        def result = kata.getInitials(array as int[])
        then:
        result == expected
        where:
        array                                   | expected
        [1, 2, 4, 5, 6, 7]                      | "124"
        [1, 2, 4, 5, 6, 7, 3, 4, 5, 6, 6, 7, 2] | "124"
        [5, 4, 6]                               | "546"
        [2, 4, 5, 6, 7]                         | "245"
    }

    def "it should return the mid three number"() {
        when:
        def result = kata.getMid(array as int[])
        then:
        result == expected
        where:
        array                                   | expected
        [1, 2, 4, 5, 6, 7]                      | "567"
        [1, 2, 4, 5, 6, 7, 3, 4, 5, 6, 6, 7, 2] | "567"
    }

    def "it should return the last four number"() {
        when:
        def result = kata.getLast(array as int[])
        then:
        result == expected
        where:
        array                                   | expected
        [1, 2, 4, 5, 6, 7]                      | "4567"
        [1, 2, 4, 5, 6, 7, 3, 4, 5, 6, 6, 7, 2] | "6672"
    }

}
