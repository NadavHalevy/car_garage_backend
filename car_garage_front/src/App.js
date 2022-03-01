import './App.css';
import Appbar from './components/Appbar'
import Vehicles from './components/Vehicles'
function App() {
  return (
    <div className="App">
      <header className="App-header">
              <Appbar />
              <Vehicles/>
      </header>
    </div>
  );
}

export default App;
