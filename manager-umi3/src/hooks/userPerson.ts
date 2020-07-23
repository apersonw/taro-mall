import { useEffect, useState } from 'react';

interface PersonObj {
  name?: string
  height?: string
  mass?: string
}

const usePerson = (personId: string): [boolean, PersonObj] => {
  const [loading, setLoading] = useState(true);
  const [person, setPerson] = useState<PersonObj>({});
  useEffect(() => {
    setLoading(true);
    let promise = fetch(`https://swapi.co/api/people/${personId}/`)
      .then(response => response.json())
      .then(data => {
        setPerson(data);
        setLoading(false);
      });
    console.log(promise)
  }, [personId]);
  return [loading, person];
};

export default usePerson;
