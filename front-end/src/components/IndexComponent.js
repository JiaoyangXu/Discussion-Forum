import React, { Component } from 'react'
import NavigationComponent from './HeaderComponent'

export default class IndexComponent extends Component {

    constructor(props) {
        super(props)

        this.state = {
            questionList: ["aaa", "bbbb"]
        }
    }

    render() {
        return (
            <div>

                <div>
                    <NavigationComponent />
                </div>
                <div>
                    {
                        this.state.questionList.map(
                            question =>
                                <h4> question</h4>
                        )
                    }
                </div>
            </div>
        )
    }
}
