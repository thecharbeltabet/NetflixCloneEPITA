import React from 'react';
import ReactDOM from 'react-dom';
import './styles/main.scss';
import './components/dummy/dummy.jsx';
function App() {
  return (
  <div>
  <h1>Starting</h1>
  <dummy></dummy>
  </div>
  );
}

ReactDOM.render(<App />, document.getElementById('root'));
