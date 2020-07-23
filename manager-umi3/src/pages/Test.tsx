import React, { useState } from 'react';
import usePerson from '@/hooks/userPerson';

const Person = ({ personId }: any) => {
  const [loading, person] = usePerson(personId);

  if (loading) {
    return <p>Loading ...</p>;
  }

  return (
    <div>
      <p>You're viewing: {person.name}</p>
      <p>Height: {person.height}</p>
      <p>Mass: {person.mass}</p>
    </div>
  );
};

function App() {
  const [show, setShow] = useState('1');

  return (
    <div className="App">
      <Person personId={show} />
      <div>
        Show:
        <button onClick={() => setShow('1')}>Luke</button>
        <button onClick={() => setShow('2')}>C-3PO</button>
      </div>
    </div>
  );
}

export default App;
