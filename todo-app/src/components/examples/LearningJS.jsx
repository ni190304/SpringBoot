const person = {
  name: 'Nihaal Nayak',
  address: {
    line1: 'Dadar',
    city : 'Mum'
  },
  profiles : ['twitter','instagram','facebook'],
  printProfile: () => {
  return person.profiles.map(
    profile => <div key={profile}>{profile}</div>
  );
}
}

export default function LearningJS(){
  return (
    <>
      <div>LearningJS</div>
    <div>{person.address.line1}</div>
    <div>{person.profiles[1]}</div>
    {person.printProfile()}
    </>
    
  )
}