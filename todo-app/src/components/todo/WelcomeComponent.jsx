import {useParams,Link} from "react-router-dom";

export default function WelcomeComponent() {
  const { username } = useParams();

  return (
    <div className="WelcomeComponent">
      <h2 className="Welcome">Welcome {username}</h2>
      <div>
        Manage your todos - <Link to="/todos">Go here</Link>
      </div>
    </div>
  );
}