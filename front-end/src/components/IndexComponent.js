import React, { Component } from 'react'
import NavigationComponent from './HeaderComponent'
import QuestionsService from '../services/QuestionService'


import { List, ListItem, Avatar, Divider, Typography, ListItemAvatar, ListItemText } from '@mui/material'

import '../css/community.css'



export default class IndexComponent extends Component {

    constructor(props) {
        super(props)

        this.state = {
            questionList: []
        }
        this.formatDateStringISO = this.formatDateStringISO.bind(this)
    }

    componentDidMount() {
        QuestionsService.getAllQuestions().then((res) => {
            this.setState({ questionList: res.data })
        })
        this.state.questionList.map(
            question =>
                console.log("Question Name: " + question)
        )
    }

    formatDateStringISO(s) {
        var b = s.split(/\D/);
        return b[2] + '-' + b[0] + '-' + b[1] +
            'T' + b[3] + ':' + b[4] + ':' + b[5] + '.000Z';
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
                                <List key={question.id} sx={{ width: '100%', maxWidth: 360, bgcolor: 'background.paper' }}>
                                    <ListItem alignItems="flex-start">
                                        <ListItemAvatar>
                                            <Avatar alt="Remy Sharp" src={question.avatarUrl} />
                                        </ListItemAvatar>
                                        <ListItemText
                                            primary={
                                                <React.Fragment>
                                                    <Typography className='index-question-title'>
                                                        {question.title}
                                                    </Typography>
                                                </React.Fragment>

                                            }
                                            secondary={
                                                <React.Fragment>
                                                    <Typography
                                                        sx={{ display: 'inline' }}
                                                        component="span"
                                                        variant="body2"
                                                        color="text.primary"
                                                    >
                                                        {question.commentCount} {"replies- "}
                                                        {question.viewCount} {"views "}
                                                    </Typography>
                                                </React.Fragment>
                                            }
                                        />
                                    </ListItem>
                                    <Divider variant="inset" component="li" />
                                </List>

                        )
                    }
                </div>
            </div>
        )
    }
}
