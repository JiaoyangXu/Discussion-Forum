import logo from './logo.svg';
import './App.css';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom'
import NavigationComponent from './components/HeaderComponent';
import PostQuestionComponent from './components/PostQuestionComponent';
import IndexComponent from './components/IndexComponent';


function App() {
  return (
    <div>
      <Router>

        <div className="container-fluid">
          <Routes>
            <Route path='/' element={<IndexComponent />}/>
            <Route path='/post-question' element={<PostQuestionComponent />} />
          </Routes>
        </div>
      </Router>
    </div>

  );
}

export default App;
