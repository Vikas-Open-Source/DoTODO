import './App.css';
import '../Dashboard/Dashboard'
import { BrowserRouter, Routes, Route} from 'react-router-dom'
import Dashboard from '../Dashboard/Dashboard';

function App() {
  return (
    <div className='wrapper'>
      <h1>DoTODO Application</h1>
      <BrowserRouter>
        <Routes>
          <Route exact path="/dashboard" element={<Dashboard />}/>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;