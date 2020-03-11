package com.utknl.katas

import spock.lang.Specification

class FindTheNextPerfectSquareSpecs extends Specification {

    def "code wars test"() {
        expect:
        assert 144L == FindTheNextPerfectSquare.findNextSquare(121)
    }

    def "it should accept perfect square"() {
        expect:
        -1L == FindTheNextPerfectSquare.findNextSquare(122)
        -1L == FindTheNextPerfectSquare.findNextSquare(114)
    }

    def "check results of Math.square()" (){
        expect:
        println Math.sqrt(114) as int
    }

}
